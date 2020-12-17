package sibsutis.labyrinth.utils;

public class Parser {
    private static final String DIVIDER = " ";

    private Parser() {
    }

    public static Integer parseLastOne(String command) {
        String[] commands = command.split(DIVIDER);
        if (commands.length != 2) {
            return null;
        }
        return parse(commands[1]);
    }

    public static Pair<Integer, Integer> parseLastTwo(String command) {
        String[] commands = command.split(DIVIDER);
        if (commands.length != 3) {
            return null;
        }
        Integer left = parse(commands[1]);
        Integer right = parse(commands[2]);
        if (left == null || right == null) {
            return null;
        }
        return Pair.of(left, right);
    }

    public static Triple<Integer, Integer, Integer> parseLastThree(String command) {
        String[] commands = command.split(DIVIDER);
        if (commands.length != 4) {
            return null;
        }
        Integer left = parse(commands[1]);
        Integer middle = parse(commands[2]);
        Integer right = parse(commands[3]);
        if (left == null || middle == null || right == null) {
            return null;
        }
        return new Triple<>(left, middle, right);
    }

    private static Integer parse(String value) {
        Integer intValue = null;
        try {
            intValue = Integer.valueOf(value.trim());
        } catch (NumberFormatException e) {

        }
        return intValue;
    }
}
