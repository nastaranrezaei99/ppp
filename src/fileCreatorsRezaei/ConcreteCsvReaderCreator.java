package fileCreatorsRezaei;

public class ConcreteCsvReaderCreator extends ReaderCreatorRezaei {

	@Override
	public ReaderProductRezaei factoryMethode() {
		// TODO Auto-generated method stub
		return new ConcreteCsvReaderProduct();
		
	}
	

}
