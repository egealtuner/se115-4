import java.util.Random;

public class LabSix {
    public static class ScenarioZero {
        public static void main(String[] args) {
            int[] myArr = {4, 8, 15, 16, 23, 42}; // create an array with 6 elements
            System.out.println("Length: " + myArr.length); // length of the array
            System.out.println("First: " + myArr[0]); // first element (index 0)
            System.out.println("Last Index: " + (myArr.length - 1)); // last index (length - 1)
            System.out.println("Third (index 2): " + myArr[2]); // third element (index 2)
            System.out.println("myArr[3]: " + myArr[3]); // element at index 3
            System.out.println("myArr[10]: " + myArr[10]); // will cause ArrayIndexOutOfBoundsException
        }
    }

    public static class ScenarioOne {
        static int[] expandRoster(int[] oldRoster, int newSize) {
            int[] newRoster = new int[newSize];
            int limit = Math.min(oldRoster.length, newSize);
            for (int i = 0; i < limit; i++) {
                newRoster[i] = oldRoster[i];
            }
            return newRoster;
        }

        public static void main(String[] args) {
            int[] oldRoster = new int[20];
            for (int i = 0; i < oldRoster.length; i++) {
                oldRoster[i] = 1000 + i;
            }
            int[] newRoster = expandRoster(oldRoster, 42);
            System.out.println("Old Roster: ");
            for (int i = 0; i < oldRoster.length; i++) {
                System.out.print(oldRoster[i] + " ");
            }
            System.out.println("\n");

            System.out.println("New Roster: ");
            for (int i = 0; i < newRoster.length; i++) {
                System.out.print(newRoster[i] + " ");
            }
        }
    }

    public static class ScenarioTwo {
        public static int[] rotateRight(int[] arr) {
            int n = arr.length;
            int[] rotated = new int[n];
            rotated[0] = arr[n - 1];
            for (int i = 1; i < n; i++) {
                rotated[i] = arr[i - 1];
            }
            return rotated;
        }

        public static void main(String[] args) {
            Random rnd = new Random();
            int arraySize = rnd.nextInt(10, 21);
            int[] arr = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                arr[i] = rnd.nextInt(100);
            }

            System.out.print("Original: ");
            for (int i = 0; i < arraySize; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(arr[i]);
            }
            System.out.println();

            int[] rotatedArr = rotateRight(arr);

            System.out.print("Rotated:  ");
            for (int i = 0; i < rotatedArr.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(rotatedArr[i]);
            }
        }
    }

    public static class ScenarioThree {
        public static void main(String[] args) {
            int amountOfForecasts = 1000000;
            String[] weatherTypes = {"Sunny", "Cloudy", "Rainy", "Stormy"};
            int[] weatherCounts = new int[4];

            int[] weatherChanceArray = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3};
            Random rnd = new Random();

            for (int i = 0; i < amountOfForecasts; i++) {
                int randomPick = rnd.nextInt(weatherChanceArray.length);
                int categoryIndex = weatherChanceArray[randomPick]; // map to weather type
                weatherCounts[categoryIndex]++;
            }

            for (int i = 0; i < weatherCounts.length; i++) {
                double percentage = 100.0 * weatherCounts[i] / amountOfForecasts;
                System.out.printf("%-7s: %,10d (%.2f%%)%n", weatherTypes[i], weatherCounts[i], percentage);
            }
        }
    }

    public static class ScenarioFour {
        public static void main(String[] args) {
            Random rnd = new Random();
            int[] arr = new int[30];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt(1, 101);
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            int peakCount = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    peakCount++;
                }
            }
            System.out.println("Count of peaks: " + peakCount);

            if (peakCount == 0) {
                System.out.println("No peaks detected.");
                return;
            }

            int[] peakIndexes = new int[peakCount];
            int currentPeakIndex = 0;

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    peakIndexes[currentPeakIndex] = i;
                    currentPeakIndex++;
                }
            }

            System.out.println("Indices: ");
            for (int i = 0; i < peakIndexes.length; i++) {
                System.out.println("The peak with the value " + arr[peakIndexes[i]] + " has the index of " + peakIndexes[i]);
            }

            int tallestPeak = arr[peakIndexes[0]];
            for (int i = 0; i < peakIndexes.length; i++) {
                if (arr[peakIndexes[i]] > tallestPeak) {
                    tallestPeak = arr[peakIndexes[i]];
                }
            }
            System.out.println("Tallest peak has the height of: " + tallestPeak);
        }
    }

    public static class BonusScenario {
        public static void main(String[] args) {
            Random rnd = new Random();
            int students = 5;
            int quizzes = 4;
            int[][] scores = new int[students][quizzes];

            for (int i = 0; i < students; i++) {
                for (int j = 0; j < quizzes; j++) {
                    scores[i][j] = rnd.nextInt(101); // 0Ã¢â‚¬â€œ100 inclusive
                }
            }

            System.out.println("Scores Table:");
            for (int i = 0; i < students; i++) {
                for (int j = 0; j < quizzes; j++) {
                    System.out.printf("%4d", scores[i][j]); // format: 4 spaces wide
                }
                System.out.println();
            }

            System.out.println("Student Averages:");
            for (int i = 0; i < students; i++) {
                int sum = 0;
                for (int j = 0; j < quizzes; j++) {
                    sum += scores[i][j];
                }
                double avg = (double) sum / quizzes;
                System.out.printf("Student %d: %.2f%n", i, avg);
            }

            System.out.println("Quiz Averages:");
            for (int j = 0; j < quizzes; j++) {
                int sum = 0;
                for (int i = 0; i < students; i++) {
                    sum += scores[i][j];
                }
                double avg = (double) sum / students;
                System.out.printf("Quiz %d: %.2f%n", j, avg);
            }

            int highestScore = scores[0][0];
            int bestStudent = 0;
            int bestQuiz = 0;

            for (int i = 0; i < students; i++) {
                for (int j = 0; j < quizzes; j++) {
                    if (scores[i][j] > highestScore) {
                        highestScore = scores[i][j];
                        bestStudent = i;
                        bestQuiz = j;
                    }
                }
            }

            System.out.printf("Highest score: %d at (studentIndex=%d, quizIndex=%d)%n",
                    highestScore, bestStudent, bestQuiz);
        }
    }
}