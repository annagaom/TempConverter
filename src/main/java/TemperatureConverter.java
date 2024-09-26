
public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static float kelvinToCel(double kel){
        return (float) (kel - 273.15);
    }
    public static double kelvinToFah(double kel) {
        return Math.round((kel - 273.15) * (9.0 / 5.0) + 32);
    }

}
