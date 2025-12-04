package fileCreatorsRezaei;

public class ConcreteCsvReaderCreatorB extends ReaderCreatorRezaei {

    @Override
    public ReaderProductRezaei factoryMethode() {
        return new ConcreteTxtReaderProduct();
    }
}
