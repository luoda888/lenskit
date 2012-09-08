/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2012 Regents of the University of Minnesota and contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.core;

import org.grouplens.lenskit.RecommenderBuildException;

/**
 * Error thrown when an error occurs resolving the recommender configuration graph.
 *
 * @since 1.0
 */
public class RecommenderConfigurationException extends RecommenderBuildException {
    public RecommenderConfigurationException() {
    }

    public RecommenderConfigurationException(String message) {
        super(message);
    }

    public RecommenderConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecommenderConfigurationException(Throwable cause) {
        super(cause);
    }

    public RecommenderConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
