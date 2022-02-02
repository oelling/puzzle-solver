public enum Side {
    FLAT, IN, OUT ;
    static final String encodings = "RIU"; // note that the string order is dependent on the order in the enum
                                    // WARNING: We will use the string as a char array

    static public Side decode(char encoding){
        int index = encodings.indexOf(encoding);
        return Side.values()[index];
    }
    static public char encode(Side side){
        return encodings.charAt(side.ordinal());
    }

    static public Side getMatch(Side side){
        return switch (side){
            case  IN -> OUT;
            case  OUT -> IN;
            case FLAT -> FLAT;
            default -> throw new IllegalStateException("Unexpected value: " + side);
        };
    }

}
