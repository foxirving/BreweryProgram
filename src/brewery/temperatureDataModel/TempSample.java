package temperatureDataModel;

public class TempSample {
	
	// The instance variables that belong to each temperature sample
	private String tempF;
	private String tempC;
	private long timeStamp;

	/**
	 * The constructor for each sample taken
	 *
	 * @param tempF
	 * @param tempC
	 * @param timeStamp
	 */
	public TempSample(String tempF, String tempC, long timeStamp) {
		this.tempF = tempF;
		this.tempC = tempC;
		this.timeStamp = timeStamp;
	}

	/**
	 * Public accessor method/getter
	 *
	 * @return Current temperature in fahrenheit.
	 */
	public String getTempF() {
		return tempF;
	}

	/**
	 * Public accessor method/getter
	 *
	 * @return Current temperature in celsius.
	 */
	public String getTempC() {
		return tempC;
	}

	/**
	 * Public accessor method/getter
	 *
	 * @return Type long date since 1970 in milliseconds
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	@Override
	/*
	 * Prints comma delimited strings ready for export to text file in order to
	 * make input into excel much easier to store data in a personal database.
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return tempF + ", " + tempC + ", " + timeStamp;
	}
	
}//end class
