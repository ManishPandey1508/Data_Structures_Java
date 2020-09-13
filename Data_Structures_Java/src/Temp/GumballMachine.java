package Temp;

public class GumballMachine {

	private int num_gumballs;
	private int quarterCount;
	private int gumballPrice;
	private int nickelCount;
	private int dimeCount;
	private int machineType;
	private int totalSum;

	/*
	 * Constructor will initialize initial size of Gumball machine, Price of each
	 * Gumball and Type of Gumball Machine
	 */
	public GumballMachine(int size, int gumballPrice, int machineType) {
		// Initialize instance variables
		this.num_gumballs = size;
		this.quarterCount = 0;
		this.gumballPrice = gumballPrice;
		this.nickelCount = 0;
		this.dimeCount = 0;
		this.machineType = machineType;
		this.totalSum = 0;
	}

	// This method will take int argument as coin and will update Total sum entered
	// and will update coin type

	public void insertCoin(int coin) {
		if (coin == 25) {
			quarterCount += 1;
			totalSum += 25;
		} else if (coin == 10) {
			dimeCount += 1;
			totalSum += 10;

		} else if (coin == 5) {
			nickelCount += 1;
			totalSum += 5;
		} else {
			return;
		}
	}

	public String turnCrank() {

		String returnString = "";
		if (this.num_gumballs == 0) {
			returnString = "Sorry!! No Gumballs left";
		}

		else if (isCoinValidForGumball()) {
			if (machineType == 0) {
				returnString = "Collect your Gumball";
				this.num_gumballs--;
				totalSum = 0;
			} else if (machineType == 1) {
				if (totalSum == 25) {
					returnString = "Insert one more quarter to get Gumball";
				} else if (totalSum == 50) {
					returnString = "Collect your Gumball";
					this.num_gumballs--;
					totalSum = 0;
				}
			} else {

				if (totalSum < 50) {
					returnString = "Insert " + (50 - totalSum) + " to get Gumball";
				} else {
					returnString = "Collect your Gumball";
					this.num_gumballs--;
					totalSum = 0;
				}
			}

		} else {
			returnString = "Please insert a valid Coin to collect a Gumball";

		}
		System.out.println(returnString);

		if (!isCoinValidForGumball() | (machineType == 2 && totalSum > 50)) {
			if (this.quarterCount != 0) {
				System.out.println("Please collect " + quarterCount + " Quarter ");
			}
			if (this.dimeCount != 0) {
				System.out.println("Please collect " + dimeCount + " Dime ");
			}
			if (this.nickelCount != 0) {
				System.out.println("Please collect " + nickelCount + " Nickel");
			}
		}
		return returnString;
	}

	public boolean isCoinValidForGumball() {
		if (machineType == 0) {
			if (quarterCount == 1) {
				quarterCount--;
				return true;
			} else {
				return false;
			}
		} else if (this.machineType == 1) {
			if (quarterCount == 1) {
				return true;
			} else if (quarterCount == 2) {
				quarterCount -= 2;
				return true;
			} else
				return false;

		} else {

			if (totalSum > 0 && totalSum < 50)
				return true;
			if (totalSum == 50) {
				quarterCount = 0;
				dimeCount = 0;
				nickelCount = 0;
				return true;
			}
			if (totalSum > 50) {
				int remainAmt = totalSum - 50;
				if (remainAmt % 25 == 0 && this.quarterCount != 0) {
					quarterCount = remainAmt / 25;
					dimeCount = 0;
					nickelCount = 0;
					return true;
				} else if (remainAmt % 10 == 0 && this.dimeCount != 0) {
					dimeCount = remainAmt / 10;
					quarterCount = 0;
					nickelCount = 0;
					return true;
				} else if (remainAmt % 5 == 0 && this.nickelCount != 0) {
					nickelCount = remainAmt / 5;
					dimeCount = 0;
					quarterCount = 0;
					return true;
				} else {
					return false;
				}

			}
			return false;
		}

	}

	public int getNum_gumballs() {
		System.out.println("Total No of gumballs left --> " + num_gumballs);
		return num_gumballs;
	}

	public void setNum_gumballs(int num_gumballs) {
		this.num_gumballs = num_gumballs;
	}

	public int getQuarterCount() {
		return quarterCount;
	}

	public void setQuarterCount(int quarterCount) {
		this.quarterCount = quarterCount;
	}

	public int getGumballPrice() {
		return gumballPrice;
	}

	public void setGumballPrice(int gumballPrice) {
		this.gumballPrice = gumballPrice;
	}

	public int getNickelCount() {
		return nickelCount;
	}

	public void setNickelCount(int nickelCount) {
		this.nickelCount = nickelCount;
	}

	public int getDimeCount() {
		return dimeCount;
	}

	public void setDimeCount(int dimeCount) {
		this.dimeCount = dimeCount;
	}

	public int getMachineType() {
		return machineType;
	}

	public void setMachineType(int machineType) {
		this.machineType = machineType;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

}