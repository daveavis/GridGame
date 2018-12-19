import java.util.EnumMap;

public class Testing
{
    public enum Value{
        EMPTY,
        FILLED
    }
    
    public enum Color{
        GREEN,
        RED
    }
    
    
    
    public static void main( String[] args )
    {
        EnumMap<Value, Color> em = new EnumMap<Value, Color>(Value.class);
        em.put(Value.EMPTY, Color.GREEN);
        em.put(Value.FILLED, Color.RED);
        
        Value[] values;
        Color[] colors;
        
        values = Value.values();
        colors = Color.values();
        
        for( Value v : values )
        {
            System.out.println( v );
        }
        for( Color c : colors )
        {
            System.out.println( c );
        }
        
        System.out.println( Value.valueOf("EMPTY") + " " + Value.FILLED );
        System.out.println( Color.GREEN + " " + Color.RED );
        //System.out.println( Value2.EMPTY + " " + Value2.FILLED );
        System.out.println( em.get(Value.EMPTY) + " " + em.get(Value.FILLED) );
    }
}