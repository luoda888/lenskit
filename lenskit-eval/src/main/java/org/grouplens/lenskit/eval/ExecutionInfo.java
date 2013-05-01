package org.grouplens.lenskit.eval;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.grouplens.lenskit.core.Shareable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean containing information about a data set.  Used to provide that information to the
 * algorithm, if it needs it for some reason.  It is best avoided, but can be useful in certain
 * experimental setups.  The evaluators inject it into the configuration, so it is available
 * via DI.
 *
 * @since 1.1
 */
@Shareable
public class ExecutionInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String algoName;
    private final Map<String, Object> algoAttributes;
    private final String dataName;
    private final Map<String, Object> dataAttributes;

    private ExecutionInfo(String aName, Map<String, Object> aAttrs,
                          String dsName, Map<String, Object> dsAttrs) {
        algoName = aName;
        algoAttributes = ImmutableMap.copyOf(aAttrs);
        dataName = dsName;
        dataAttributes = ImmutableMap.copyOf(dsAttrs);
    }

    /**
     * Get the algorithm name.
     * @return The algorithm name.
     */
    public String getAlgoName() {
        return algoName;
    }

    /**
     * Get the algorithm attributes.
     * @return The algorithm attributes.
     */
    public Map<String, Object> getAlgoAttributes() {
        return algoAttributes;
    }

    /**
     * Get the data set name.
     * @return The data set name.
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * Get the data set attributes.
     * @return The data set attributes.
     */
    public Map<String, Object> getDataAttributes() {
        return dataAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof ExecutionInfo) {
            ExecutionInfo eo = (ExecutionInfo) o;
            EqualsBuilder eqb = new EqualsBuilder();
            return eqb.append(algoName, eo.algoName)
                      .append(algoAttributes, eo.algoAttributes)
                      .append(dataName, eo.dataName)
                      .append(dataAttributes, eo.dataAttributes)
                      .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(algoName)
                  .append(algoAttributes)
                  .append(dataName)
                  .append(dataAttributes)
                  .hashCode();
    }

    public static class Builder implements org.apache.commons.lang3.builder.Builder<ExecutionInfo> {
        private String algoName;
        private Map<String, Object> algoAttributes = new HashMap<String, Object>();
        private String dataName;
        private Map<String, Object> dataAttributes = new HashMap<String, Object>();

        public Builder setAlgoName(String algoName) {
            this.algoName = algoName;
            return this;
        }

        public Builder setAlgoAttributes(Map<String, Object> attrs) {
            algoAttributes = new HashMap<String,Object>(attrs);
            return this;
        }

        public Builder setDataName(String dataName) {
            this.dataName = dataName;
            return this;
        }

        public Builder setDataAttributes(Map<String, Object> attrs) {
            dataAttributes = new HashMap<String, Object>(attrs);
            return this;
        }

        @Override
        public ExecutionInfo build() {
            return new ExecutionInfo(algoName, algoAttributes,
                                     dataName, dataAttributes
            );
        }
    }
}
