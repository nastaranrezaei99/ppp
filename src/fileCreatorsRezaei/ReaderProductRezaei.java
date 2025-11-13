package fileCreatorsRezaei;

import java.io.IOError;
import java.io.IOException;

public abstract class ReaderProductRezaei {
	
	public abstract  String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}