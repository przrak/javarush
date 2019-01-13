package ru.javarush.pr1zrak.testtask.support;

public enum FilterType {
    ALL{
        public String toString() {
            return "all";
        }
    },
    OPTIONAL{
        public String toString() {
            return "optional";
        }
    },
    NEEDED{
        public String toString() {
            return "needed";
        }
    },
    SEARCH{
        public String toString() {
            return "search";
        }
    }
}
