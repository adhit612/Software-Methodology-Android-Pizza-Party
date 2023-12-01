package com.softwaremethodologyandroidpp;

/**
 * Class that manages Sauce types for pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public enum Sauce {
    TOMATO {
        /**
         * Method that handles getting the sauce of the pizza.
         * @return sauce of pizza.
         */
        @Override
        public String toString() {
            return "Tomato";
        }
    },
    ALFREDO {
        /**
         * Method that handles getting the sauce of the pizza.
         * @return sauce of pizza.
         */
        @Override
        public String toString() {
            return "Alfredo";
        }
    },
}
