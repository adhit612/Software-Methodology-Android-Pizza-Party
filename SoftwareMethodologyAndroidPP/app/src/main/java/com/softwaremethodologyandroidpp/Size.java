package com.softwaremethodologyandroidpp;

/**
 * Class that manages sizes of pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public enum Size {
    SMALL {
        /**
         * Method that handles size of pizza.
         * @return small size of pizza.
         */
        @Override
        public String toString() {
            return "Small";
        }
    },
    MEDIUM {
        /**
         * Method that handles size of pizza.
         * @return medium size of pizza.
         */
        @Override
        public String toString() {
            return "Medium";
        }
    },
    LARGE {
        /**
         * Method that handles size of pizza.
         * @return large size of pizza.
         */
        @Override
        public String toString() {
            return "Large";
        }
    },
}
