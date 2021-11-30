import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

interface Subject {
	public void RegisterObserver(Observer o);

	public void UnRegisterObserver(Observer o);

	public void NotifyObservers();
}

interface Observer {
	public void update(int runs, int wickets, float overs);
}

class CricketData implements Subject {
	int runs;
	int wickets;
	float overs;
	ArrayList<Observer> observerList;

	public CricketData() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void RegisterObserver(Observer o) {
		observerList.add(o);
	}

	@Override
	public void UnRegisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void NotifyObservers() {
		for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(runs, wickets, overs);
		}
	}

	// get latest runs from stadium
	private int getLatestRuns() {
		// return 90 for simplicity
		return 90;
	}

	// get latest wickets from stadium
	private int getLatestWickets() {
		// return 2 for simplicity
		return 2;
	}

	// get latest overs from stadium
	private float getLatestOvers() {
		// return 90 for simplicity
		return (float) 10.2;
	}

	// This method is used update displays
	// when data changes
	public void dataChanged() {
		// get latest data
		runs = getLatestRuns();
		wickets = getLatestWickets();
		overs = getLatestOvers();

		NotifyObservers();
	}
}

class AverageScoreDisplay implements Observer {
	private float runRate;
	private int predictedScore;

	public void update(int runs, int wickets, float overs) {
		this.runRate = (float) runs / overs;
		this.predictedScore = (int) (this.runRate * 50);
		display();
	}

	public void display() {
		System.out.println(
				"\nAverage Score Display: \n" + "Run Rate: " + runRate + "\nPredictedScore: " + predictedScore);
	}
}

class CurrentScoreDisplay implements Observer {
	private int runs, wickets;
	private float overs;

	public void update(int runs, int wickets, float overs) {
		this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		display();
	}

	public void display() {
		System.out
				.println("\nCurrent Score Display:\n" + "Runs: " + runs + "\nWickets:" + wickets + "\nOvers: " + overs);
	}
}

public class ObserverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

// pass the displays to Cricket data
		CricketData cricketData = new CricketData();

// register display elements
		cricketData.RegisterObserver(averageScoreDisplay);
		cricketData.RegisterObserver(currentScoreDisplay);

// in real app you would have some logic to
// call this function when data changes
		cricketData.dataChanged();

//remove an observer
		cricketData.UnRegisterObserver(averageScoreDisplay);

// now only currentScoreDisplay gets the
// notification
		cricketData.dataChanged();
	}

}
