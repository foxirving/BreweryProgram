package temperatureDataModel;

import java.util.ArrayList;

/**
 * Public class used to create an instance of an array object that stores
 * temperature samples
 *
 */
public class TempHist {
	/*
	 * ArrayList of Type TempSample used to store temperature samples taken ever
	 * second
	 */
	private ArrayList<TempSample> sample = new ArrayList<>();

	/**
	 * Public setter used to append a new element to the array of temperature
	 * samples
	 *
	 * @param newTempF
	 * @param newTempC
	 * @param newTimeStamp
	 */
	public void add(String newTempF, String newTempC, long newTimeStamp) {
		sample.add(new TempSample(newTempF, newTempC, newTimeStamp));
	}

	/**
	 * Public instance method used to access a specific temperature sample in
	 * the array.
	 *
	 * @param index
	 * @return Returns the element at the specified index position.
	 */
	public TempSample get(int index) {
		return sample.get(index);
	}

	/**
	 * Public instance method used to get the total size of the temperature
	 * sample array
	 *
	 * @return The number of temperature samples stored in the arraylist
	 */
	public int getSize() {
		return sample.size();
	}

	/**
	 * Instance method that checks returns the most recent temperature sample in
	 * the array as long as the array is not empty
	 * 
	 * <pre>
	 * Usage: <b>tempHist.getLatest().getTempF(), <b>tempHist.getLatest().getTempC(),
	 * or <b>tempHist.getLatest().getTimeStamp()</b>
	 *
	 * @return
	 */
	public TempSample getLatest() {
		if (getSize() == 0) {
			return null;
		}
		return (sample.get(getSize() - 1));
	}
}
