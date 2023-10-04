/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.utils;

public enum ResponseTypes {
    JSON {
        @Override
        public String toString() {
            return "application/json";
        }
    },
    XML {
        @Override
        public String toString() {
            return "application/xml";
        }
    },
    PLAIN {
        @Override
        public String toString() {
            return "text/plain";
        }
    },
}
