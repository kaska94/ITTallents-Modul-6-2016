package Telephone;

import java.text.DecimalFormat;

public class GSMDemo {
	public static void main(String[] args) {
		DecimalFormat decimalFormatter = new DecimalFormat();
		decimalFormatter.setMaximumFractionDigits(2);

		Gsm nokia = new Gsm();
		nokia.model = "nokia";
		nokia.insertSimCard("0893575282");

		Gsm siemens = new Gsm();
		siemens.insertSimCard("0893575281");
		siemens.model = "siemens";
		
		System.out.println();
		System.out.println("All calls nokia: " + decimalFormatter.format(nokia.sumForCall()) + " BNG");
		System.out.println("All calls siemens: " + decimalFormatter.format(siemens.sumForCall()) + " BNG");

		nokia.call(siemens, 2.3f);
		siemens.call(nokia, 6.20f);

		nokia.call(siemens, 2.3f);
		//siemens.removeSimCard();
		nokia.call(siemens, 13.3f);

		System.out.println("\nEnding result");
		nokia.printInfoForTheLastOutgoingCall();
		nokia.printInfoForTheLastIncomingCall();
		siemens.printInfoForTheLastOutgoingCall();
		siemens.printInfoForTheLastIncomingCall();

		System.out.println();
		System.out.println("All calls nokia: " + decimalFormatter.format(nokia.sumForCall()) + " BNG");
		System.out.println("All calls siemens: " + decimalFormatter.format(siemens.sumForCall()) + " BNG");

	}
}
