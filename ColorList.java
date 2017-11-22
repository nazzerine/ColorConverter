/**
 * This class is used to store all the Color objects whose hexadecimal value and name 
 * are provided in the input file.
 * 
 * @author Nazzzerine Waldon
 * @version 09/19/2017
 */

package project1;

import java.util.ArrayList;

public class ColorList extends ArrayList<Color> {

	/**
	 * Default constructor that creates an empty list
	 */
	public ColorList () {
	}
	
	/**
	 * Iterates over the list until the object matching the name is found or the end of the list is reached
	 * 
	 * @param colorName is the name of the color trying to find a match
	 * 
	 * @return the object matching the name, or null if match is not found
	 */
	public Color getColorByName(String colorName) {
		for (int i = 0; i < super.size(); i++) 
		{
			if (super.get(i).getName() == null) {
				if (colorName == null) {
					return super.get(i);
				}
			} else 
				if (super.get(i).getName().equalsIgnoreCase(colorName)){
					return super.get(i);
				}		
		}
		// match not found so return null
		return null;
		
	}
	
	/**
	 * Iterates over the list until the object matching the hexValue is found or the end of the list is reached
	 * 
	 * @param colorHexValue is the hex value of the color trying to find a match
	 * 
	 * @return the object matching the Hex value, or null if match is not found
	 */
	public Color getColorByHexValue (String colorHexValue) {
		for (int i = 0; i < super.size(); i++) 
		{
			if (super.get(i).getHexValue().equals(colorHexValue)) {
				return super.get(i);
			}
		}
		// match not found, so return null
		return null;
	}
}
