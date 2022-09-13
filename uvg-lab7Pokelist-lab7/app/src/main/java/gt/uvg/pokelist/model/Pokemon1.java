package gt.uvg.pokelist.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon1 implements Parcelable {
    private String nombre;
    private int id;

    public Pokemon1(int id, String nombre){
        this.nombre=nombre;
        this.id=id;
    }

    public String getFront(){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }

    public String getBack(){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }

    public String getFrontS(){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }

    public String getBackS(){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }

    public String getNombre(){
        return nombre;
    }

    protected Pokemon1(Parcel in) {
        nombre = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pokemon1> CREATOR = new Creator<Pokemon1>() {
        @Override
        public Pokemon1 createFromParcel(Parcel in) {
            return new Pokemon1(in);
        }

        @Override
        public Pokemon1[] newArray(int size) {
            return new Pokemon1[size];
        }
    };
}
