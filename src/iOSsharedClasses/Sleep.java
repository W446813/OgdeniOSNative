package iOSsharedClasses;

import java.util.concurrent.TimeUnit;

public class Sleep {

	public Sleep() {
	}

	public Sleep ThreadSleep3000() throws Exception {

		try {
			Thread.sleep(3000, 3000);

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}

	public Sleep ThreadSleep1() throws Exception {

		try {
			Thread.sleep(1);

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}

	public Sleep ThreadSleep2000() throws Exception {

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	public Sleep Sleep9() throws Exception {

		try {
			 TimeUnit.SECONDS.sleep(9);

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
}
