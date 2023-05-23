public class Main
{
    public static void main(String[] args)
    {
        ADS2Vector vec = new ADS2Vector();
        vec.Append(23);
        vec.Append(120);
        vec.Append(420);
        vec.Append(421);
        vec.Append(422);
        vec.Append(423);
        vec.Append(424);
        vec.Append(425);
        vec.Append(426);

        //int f = vec.Find(120);
        //System.out.println(f);

        vec.InsertItem(3, 1000);
    }
}