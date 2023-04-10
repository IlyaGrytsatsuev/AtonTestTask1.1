import java.util.*;

public class inMemorySimpleDB {
    private final TreeMap<Long, Data> accountIndexMap;
    private final TreeMap<String, Data> nameIndexMap;
    private final TreeMap<Double, Data> valueIndexMap;

    public inMemorySimpleDB() {
        accountIndexMap = new TreeMap<>();
        nameIndexMap = new TreeMap<>();
        valueIndexMap = new TreeMap<>();
    }

    public void insert(long account, String name, double value) {
        Data record = new Data(account, name, value);
        accountIndexMap.put(account, record);
        nameIndexMap.put(name, record);
        valueIndexMap.put(value, record);

    }

    public void update(long account, Object[] updateValues){
        Data record = accountIndexMap.get(account);
        Data recordCopy = new Data(record);
        for(Object obj : updateValues){
            if(obj instanceof Long)
                record.setAccount((long) obj);
            if(obj instanceof String)
                record.setName((String) obj);
            if(obj instanceof Double)
                record.setValue((double) obj);
        }
        if(account != record.getAccount()) {
            accountIndexMap.remove(record);
            accountIndexMap.put(record.getAccount(), record);
        }
        if(!record.getName().equals(recordCopy.getName())){
            nameIndexMap.remove(recordCopy.getName());
            nameIndexMap.put(record.getName(), record);
        }
        if(record.getValue()!= recordCopy.getValue()){
            valueIndexMap.remove(recordCopy.getValue());
            valueIndexMap.put(record.getValue(), record);
        }

    }

    public void delete(long account) {
        Data deleteRecord = accountIndexMap.get(account);
        deleteByName(deleteRecord.getName());
        deleteByValue(deleteRecord.getValue());
        deleteByAccount(account);
    }

    public void deleteByName(String name){
        nameIndexMap.remove(name);
    }

    public void deleteByValue(double value){
        valueIndexMap.remove(value);
    }
    public void deleteByAccount(long account){
        accountIndexMap.remove(account);
    }
    public Data getRecordByName(String name){
        return nameIndexMap.get(name);
    }

    public Data getRecordByValue(double value){
        return valueIndexMap.get(value);
    }
    public Data getRecordByAccount(long account){
        return accountIndexMap.get(account);
    }



}
