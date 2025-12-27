package practice.thetopics;

public class stbuilderbuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Atharv");
        sb.append("Borate");

        System.out.println(sb);// string buffer ek alag type ka data hota hai memeory me string ke saath extra buffer bhi add hota hai 16 byts ka isliye baad me add kar sakte hai isme data ko

        String str = sb.toString(); // ye apan ne normal string me convert kar diya

        // aur bhi string ke methods hote hai i mean string buffer ke methods hote hai unke notes ban lenge
    }

}
