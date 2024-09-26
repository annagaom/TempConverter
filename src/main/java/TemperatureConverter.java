public class TemperatureConverter {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static float kelvinToCel(double kel) {
        return (float) (kel - 273.15);
    }

    public static double kelvinToFah(double kel) {
        return Math.round((kel - 273.15) * (9.0 / 5.0) + 32);
    }

    // Main method for testing the temperature conversion methods
    public static void main(String[] args) {
        // Test cases
        double fahrenheit = 32;
        double celsius = 0;
        double kelvin = 300.1;

        // Fahrenheit to Celsius
        System.out.println(fahrenheit + " °F is " + fahrenheitToCelsius(fahrenheit) + " °C");

        // Celsius to Fahrenheit
        System.out.println(celsius + " °C is " + celsiusToFahrenheit(celsius) + " °F");

        // Check extreme temperature
        System.out.println(celsius + " °C is extreme: " + isExtremeTemperature(celsius));

        // Kelvin to Celsius
        System.out.println(kelvin + " K is " + kelvinToCel(kelvin) + " °C");

        // Kelvin to Fahrenheit
        System.out.println(kelvin + " K is " + kelvinToFah(kelvin) + " °F");
    }
}
