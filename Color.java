/**
 * The Color class stores information about a particular color.
 * 
 * @author Nazzzerine Waldon
 * @version 09/19/2017
 */

package project1;

public class Color implements Comparable<Color>{
	
	// colorHexValue and colorName need to be accessed in the ColorList class
	protected String colorHexValue;
	protected String colorName;
	// red, green, and blue only need to be accessed in the Color class
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Overrides the equals method in the Object class
	 * 
	 * @param o is an instance of Object that is converted to an instance of Color
	 * 
	 * @return true if the hexadecimal strings of the two Color objects are the same.
	 */
	@Override
	public boolean equals(Object o) {
		// if the hexadecimal representations are equal
		Color c = (Color) o;
		if (this.colorHexValue.equalsIgnoreCase(c.colorHexValue)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Alpha numerically compares the hexadecimal value associated with the color
	 * 
	 * @param c is a Color object
	 * 
	 * @return the integer associated with the comparison
	 */
	public int compareTo (Color c) {
		return (this.colorHexValue.compareToIgnoreCase(c.colorHexValue));	
	}
	
	/**
	 * Constructs an instance of color using the hexadecimal value and converts from Hex to RGB
	 * 
	 * @param colorHexValue is the hexadecimal value of a color
	 * 
	 * @throws IllegalArgumentException if what is entered is not a valid color specification.
	 */
	public Color ( String colorHexValue ) throws IllegalArgumentException {
		// if the input is in the wrong format, throw exception
		if (colorHexValue.charAt(0) != '#') {
			throw new IllegalArgumentException("Error: This is not a valid color specifiction.");
		}
		
		if (colorHexValue.length() != 7) {
			throw new IllegalArgumentException("Error: This is not a valid color specifiction.");
		}
		
		// if valid, make sure that the letters are valid, otherwise throw exception
		if (colorHexValue.charAt(0) == '#' && colorHexValue.length() == 7) {
			for (int i = 1; i < colorHexValue.length(); i++) 
			{
				char index = colorHexValue.charAt(i);
				if (Character.isLetter(index)) {
					index = Character.toLowerCase(index);
					if (index <'a'|| index > 'f') {
						throw new IllegalArgumentException("Error: This is not a valid color specification.");		
					}
				}
			}
		}
		
		this.colorHexValue = colorHexValue;
		
		// convert from Hex to RGB for red, green, and blue
		red = Integer.valueOf(colorHexValue.substring(1, 3), 16);
		blue = Integer.valueOf(colorHexValue.substring(5, 7), 16);
		green = Integer.valueOf(colorHexValue.substring(3,5), 16);
	}
	
	/**
	 * Constructs an instance of color using the hexadecimal value and name of the color. It also converts from Hex to RGB
	 * 
	 * @param colorHexValue is the hexadecimal value of a color, colorName is the name of the color.
	 * 
	 * @throws IllegalArgumentException if what is entered is not a valid color specification.
	 */
	public Color ( String colorHexValue, String colorName ) throws IllegalArgumentException {
		// if input is in the wrong format, throw exception
		if (colorHexValue.charAt(0) != '#') {
				throw new IllegalArgumentException("Error: This is not a valid color specifiction.");
		}
		if (colorHexValue.length() != 7) {
			throw new IllegalArgumentException("Error: This is not a valid color specifiction."); 
		}
		// if valid, make sure that the letters are valid, otherwise throw exception
		if (colorHexValue.charAt(0) == '#' && colorHexValue.length() == 7) {
			for (int i = 1; i < colorHexValue.length(); i++) 
			{
				char index = colorHexValue.charAt(i);
					if (Character.isLetter(index)) {
						index = Character.toLowerCase(index);
						if (index <'a'|| index > 'f') {
							throw new IllegalArgumentException("Error: This is not a valid color specifiction.");
						}
					}
			}
		}
		
		this.colorHexValue = colorHexValue;
		this.colorName = colorName;
		
		// convert from Hex to RGB for red, green, and blue
		red = Integer.valueOf(colorHexValue.substring(1, 3), 16);
		green = Integer.valueOf(colorHexValue.substring(3,5), 16);
		blue = Integer.valueOf(colorHexValue.substring(5, 7), 16);
	}
	
	/**
	 * Constructs an instance of color using the RGB values and converts from RGB to Hex
	 * 
	 * @param red, green, and blue are integer RGB values
	 * 
	 * @throws IllegalArgumentException if what is entered is not a valid color specification.
	 */
	public Color ( int red, int green, int blue ) throws IllegalArgumentException {
		// since given rgb values, no rgb to hex converter needed
		this.red = red;
		this.green = green;
		this.blue = blue;
		
		//if the rgb values aren't valid, throw exception
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue> 255) {
			throw new IllegalArgumentException("Error: This is not a valid color specifiction.");
		}
		// convert from rgb to hex
		colorHexValue = String.format("#%02x%02x%02x", red, green, blue);
	}
	
	/**
	 * Returns the value of the red component.
	 * 
	 * @return the red component
	 */
	public int getRed() {
		return red;
	}
	
	/**
	 * Returns the value of the green component.
	 * 
	 * @return the green component
	 */
	public int getGreen() {
		return green;
	}
	
	/**
	 * Returns the value of the blue component.
	 * 
	 * @return the blue component
	 */
	public int getBlue() {
		return blue;
	}
	
	/**
	 * Returns the name of the color from colorName
	 * 
	 * @return name of the color or null if there is none
	 */
	public String getName() {
		if (this.colorName != null) {
			return this.colorName;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the Hex Value
	 * 
	 * @return the hex value of each color
	 */
	public String getHexValue() {
		return colorHexValue;
	}
	
	/**
	 * Overrides the toString method so that it returns in the desired format
	 * 
	 * @return #HEXVAL, (  0,  0,  0), COLORNAME if colorName exists
	 * otherwise, #HEXVAL, (  0,  0,  0)
	 */
	@Override
	public String toString() {
		// override the toString method so that it returns in the desired format
		String stringToReturn;
		
		if (this.colorName == null) {
			stringToReturn = (this.colorHexValue.toUpperCase() + ", " + String.format("(%3d,%3d,%3d)", this.red, this.green, this.blue));
		} else {
			stringToReturn = (this.colorHexValue.toUpperCase() + ", " + String.format("(%3d,%3d,%3d)", this.red, this.green, this.blue) + ", " + this.colorName);
		}
		return stringToReturn;
	}
}
