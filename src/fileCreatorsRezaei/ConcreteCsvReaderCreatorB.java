package fileCreatorsRezaei;

public class ConcreteCsvReaderCreatorB extends ReaderCreatorRezaei {

	@Override
	public ReaderProductRezaei factoryMethode() {
		// TODO Auto-generated method stub
		

		
		return new ConcreteTxtReaderProduct();
		
	}
	
	

}
