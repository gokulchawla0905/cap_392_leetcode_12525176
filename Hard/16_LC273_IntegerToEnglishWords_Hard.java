class Solution {
    private final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
        "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int group = 0;

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                String words = convert(part);

                if (!thousands[group].isEmpty()) {
                    words += " " + thousands[group];
                }

                result = words + (result.isEmpty() ? "" : " " + result);
            }

            num /= 1000;
            group++;
        }

        return result;
    }

    private String convert(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            String result = tens[num / 10];

            if (num % 10 != 0) {
                result += " " + belowTwenty[num % 10];
            }

            return result;
        }

        String result = belowTwenty[num / 100] + " Hundred";

        if (num % 100 != 0) {
            result += " " + convert(num % 100);
        }

        return result;
    }
}