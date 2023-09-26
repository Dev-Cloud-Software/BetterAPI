/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.utils;

public enum ResponseTypes {
    JSON {
        public String toString() {
            return "application/json";
        }
    },
    XML {
        public String toString() {
            return "application/xml";
        }
    },
    PLAIN {
        public String toString() {
            return "text/plain";
        }
    },
}
