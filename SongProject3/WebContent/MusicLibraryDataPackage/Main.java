/*	
	Main.java - Test implementations of all methods.
 */

package MusicLibraryDataPackage;

public class Main {

	public static void main(String[] args) {
		// File name to read and write from
		String fileName = "MusicLibraryDataPackage/testTracks.csv";

		// Instantiate Collection object and read in .csv content
		Collection collection = new Collection();
		Collection suggestions = new Collection();
		collection.readFile(fileName);
		suggestions.readFile(fileName);

		String fullFile = "MusicLibraryDataPackage/finalTracks.csv";
		Collection allTheSongs = new Collection();
		allTheSongs.readFile(fullFile);

		System.out.print("All Gernes: ");
		String[] genres = allTheSongs.getGenres();
		System.out.print("("+genres.length+")");
		for (int i = 0; i < genres.length; i++) {
			String s = genres[i];
			System.out.print(s+"/");
		}
		System.out.println();

		// Testing Song Methods:
		// Constructors and toString:
		System.out.println("Testing Song Constructors, Setters, Getters, and toString:\n");

		Song song1 = new Song();
		Song song2 = new Song(2000);
		Song song3 = new Song(1, "Test", "Test", "Test", "Test", 2021, 0);
		System.out.println("Song 1: " + song1);
		System.out.println("Song 2: " + song2);
		System.out.println("Song 3: " + song3);

		// Getters and Setters
		String toDisplay = song1.getID() + "," + song1.getArtist() + "," + song1.getGenre() + "," + song1.getName() + "," + song1.getAlbum() + "," + song1.getYear() + "," + song1.getLongitude();
		System.out.println("Song 1 via Getters: " + toDisplay);
		song1.setID(0);
		song1.setArtist("0");
		song1.setGenre("0");
		song1.setName("0");
		song1.setAlbum("0");
		song1.setYear(0);
		song1.setLongitude(0.0);
		System.out.println("Song 1 after Setters: " + song1);


		// Testing Song Equality
		System.out.println("Testing Song Equality:\n");
		Song songA = new Song(0);
		Song songB = new Song(1, "Test", "Test", "Test", "Test", 2021, 0);
		Song songC = new Song(0);
		boolean AvsB = songA.equals(songB);
		boolean AvsC = songA.equals(songC);
		boolean BvsC = songB.equals(songC);
		System.out.println("Song A vs. Song B (should be False): " + AvsB);
		System.out.println("Song A vs. Song C (should be True): " + AvsC);
		System.out.println("Song B vs. Song C (should be False): " + BvsC);


		// Collections - add(), remove(), display(), and getIterator()
		System.out.println("\n\nTesting add(), remove(), display(), and getIterator():\n");
		System.out.println("\nCollection before Adding songA:");
		collection.display();
		System.out.println("\nCollection after Adding songA:");
		collection.add(songA);
		collection.display();
		System.out.println("\nCollection after Removing songA:");
		collection.remove(songA);
		collection.display();


		// Collections - empty(), size(), and returnFirst()
		Collection emptytest = new Collection();
		System.out.println("\nTesting Empty Collection (should be True, 0): " + emptytest.empty() + " \nSize: " + emptytest.size());

		System.out.println("\nTesting Filled Collection (should be False, 7): " + collection.empty() + " \nSize: " + collection.size());

		System.out.println("\nTesting returnFirst() on Empty: " + emptytest.returnFirst());

		System.out.println("\nTesting returnFirst() on Filled: " + collection.returnFirst());


		// Collections - addAll()
		System.out.println("\nTesting addAll(): ");
		collection.addAll(emptytest);
		emptytest.addAll(collection);
		emptytest.display();


		// Collections - contains()
		collection.add(songB);
		System.out.println("\nTesting Collection for containing SongB (should be True): " + collection.contains(songB));
		System.out.println("Testing Collection for containing SongA (should be False): " + collection.contains(songA));


		// Collections - Find Functions (ID, Genre, and Artist)
		System.out.println("\nTesting Find Functions (next four lines should be the same): ");
		System.out.println(songB);
		emptytest = collection.findSongByGenre(songB.getGenre());
		emptytest.display();
		emptytest = collection.findSongByArtist(songB.getArtist());
		emptytest.display();
		song3 = collection.findSongByID(songB.getID());
		System.out.println(song3);

		// Collections - One Input, One Output Suggestion
		System.out.println("\nTesting Suggest Function, 1 Input 1 Output: ");
		Song HipHopAWOL1 = suggestions.returnFirst();
		Song HipHopAWOL2 = suggestions.suggestSong_1I1O(HipHopAWOL1);
		System.out.println("Input Song: " + HipHopAWOL1);
		System.out.println("Suggested: " + HipHopAWOL2);


		// Collections - One Input, Many Output Suggestion
		System.out.println("\nTesting Suggest Function, 1 Input Many Output: ");
		Song Folk1 = new Song(23,"Ed Askew","Folk","Test Song","Blue Piano",2008,-74.0059731);
		Collection FolkC = suggestions.suggestSong_1IMO(Folk1);
		System.out.println("Input Song: " + Folk1);
		System.out.println("Suggested: ");
		FolkC.display();


		// Collections - Many Input, One Output Suggestion
		System.out.println("\nTesting Suggest Function, Many Input 1 Output: ");
		suggestions.add(new Song(192,"Ed Askew","Folk","Test","Test",2008,-74.0059731));
		Folk1 = suggestions.suggestSong_MI1O(FolkC);
		System.out.println("Input Songs: ");
		FolkC.display();
		System.out.println("Suggested: " + Folk1);


		// Collections - Many Input, Many Output Suggestion
		System.out.println("\nTesting Suggest Function, Many Input Many Output: ");
		Collection FolkSongs = new Collection();
		FolkSongs.add( new Song(23,"Ed Askew","Folk","Test Song 1","Blue Piano",2008,-74.0059731));
		FolkSongs.add( new Song(23,"Alec K. Redfearn & the Eyesores","Folk","Test Song 2","Blue Piano",2008,-74.0059731));
		FolkSongs.add( new Song(23,"Alec K. Redfearn & the Eyesores","Folk","Test Song 3","Blue Piano",2008,-74.0059731));
		FolkSongs.add( new Song(23,"Ed Askew","Folk","Test Song 4","Blue Piano",2008,-74.0059731));

		System.out.println("Input Songs: ");
		FolkSongs.display();
		FolkC = suggestions.suggestSong_MIMO(FolkSongs);
		System.out.println("Suggested: ");
		FolkC.display();


		// Collections - Write to File
		FolkC.writeFile(fileName);

	}
}