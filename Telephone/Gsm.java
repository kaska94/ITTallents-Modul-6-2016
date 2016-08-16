package Telephone;

import java.text.DecimalFormat;

public class Gsm {
	String model;
	boolean hasSimCard;
	private String number;
	double outgoingCallsDuration = 0;
	Call lastIncomingCall;
	Call lastOutgoingCall;

	void call(Gsm toWhom, float duration) {

		if ((duration <= 0) || (duration > 60)) {
			System.out.println("It must be atleast 0.1 and cant be above 60 min");
			return;
		}

		if ((model == "") || (model == null) || (toWhom.model == "") || (toWhom.model == null)) {
			System.out.println("Telephone must have model");
			return;
		}

		if ((toWhom.hasSimCard == true) && (this.hasSimCard == true)) {
			if (!toWhom.number.equals(number)) {
				Call tempCall = new Call();
				tempCall.duratiion = duration;
				tempCall.caller = this; // calling from this GSM
				tempCall.receiver = toWhom; // to parameter GSM

				toWhom.lastIncomingCall = tempCall; // added last incoming call
				this.lastOutgoingCall = tempCall; // added last outgoing call to
													// this object
				printInfoForTheLastOutgoingCall();
				outgoingCallsDuration += duration;
			} else {
				System.out.println("Gsms can't call themselves...");
				return;
			}
		} else {
			System.out.println("Both devices need to have a sim card");
			return;
		}

	}

	void insertSimCard(String newNmber) {
		if ((newNmber == null || (newNmber.equals("")))) {
			System.out.println("Must be not empty string!");
			return;
		}

		if ((number != null) && (number.length() == 10)) {
			System.out.println("Already inseted. Your Number is " + number);
			return;
		}

		if (newNmber.length() != 10) {
			System.out.println("Number has 10 digits.\n");
			return;
		} else {
			boolean areAllDigits = true;
			for (int index = 0; index < newNmber.length(); index++) {
				if (!Character.isDigit(newNmber.charAt(index))) {
					areAllDigits = false;
				}
			}
			if (areAllDigits) {
				if ((newNmber.charAt(0) == '0') && (newNmber.charAt(1) == '8')) {
					hasSimCard = true;
					number = newNmber;
				} else {
					System.out.println("Not Valid numbers, must start with 08.....");
					return;
				}
			} else {
				System.out.println("Not all numbers are digits.");
				return;
			}
		}
	}

	void removeSimCard() {
		if ((hasSimCard) && (number != null) && (!number.equals(""))) {
			hasSimCard = false;
			number = null;
		} else {
			System.out.println("There is no sim to remove...");
			return;
		}
	}

	float sumForParticularCall(float duration) {
		return (duration > 0) ? duration * Call.priceForMinute : 1;
	}

	float sumForCall() {
		return (outgoingCallsDuration > 0) ? (float) (outgoingCallsDuration * Call.priceForMinute) : 0;
	}

	void printInfoForTheLastOutgoingCall() {
		/*
		 * this is for displaying only two numbers from the fraction we can use
		 * printf too but... i just didnt want to do this i hope it's not a
		 * problem ;)
		 */
		DecimalFormat decimalFormatter = new DecimalFormat();
		decimalFormatter.setMaximumFractionDigits(2);

		if ((model == null) && model.equals("")) {
			System.out.println("Model is no inserted");
			return;
		}
		if (lastOutgoingCall == null) {
			System.out.println("No call is made");
			return;
		}

		System.out.println(model + " last outgoing call has " + lastOutgoingCall.duratiion + " minutes "
				+ decimalFormatter.format(sumForParticularCall(lastOutgoingCall.duratiion)) + " BGN");
	}

	void printInfoForTheLastIncomingCall() {
		DecimalFormat decimalFormatter = new DecimalFormat();
		decimalFormatter.setMaximumFractionDigits(2);

		if ((model == null) && model.equals("")) {
			System.out.println("Model is no inserted");
			return;
		}

		if (lastIncomingCall == null) {
			System.out.println("No one called you. You have no friends. :(");
			return;
		}

		System.out.println(model + " last incomming call has " + lastIncomingCall.duratiion + " minutes "
				+ decimalFormatter.format(sumForParticularCall(lastIncomingCall.duratiion)) + " BGN");
	}
}
