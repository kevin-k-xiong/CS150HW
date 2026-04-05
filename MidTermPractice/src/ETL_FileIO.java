public class ETL_FileIO {

    /*
     * difference between buffered and non-buffered file readers/writeres
     * BUffered uses temp memory to store data (consistant speed)
     * nonBuffered writes/reads by directly accessing the disk (Various speeds)
     * What is the point
     * 
     * 
     * What is ETL? Psuedocode example...
     * Extract, Transform, Load
     * A proces to turn information from multiple sources into one consistant and
     * readable format
     * 
     * Psuedocode code
     * //Extract
     * Data[] dataArr = getDataFromSource();
     * 
     * //Transform
     * Arraylist<CustomObject> cleanedData = new ArrayList<>();
     * for(RawData t : dataArr){
     * CustomOnkect cleaned = cleanUp(r);
     * cleanedData.add()
     * }
     * 
     * //Load
     * for(CustomOnkect c : cleanedData){
     *     doStuffElsewhereInProgram(c);
     * }
     *
     * 
     */

}
