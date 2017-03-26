package eliran.recepie.com.recepiesearch;

import android.os.Parcel;
import android.os.Parcelable;


public class recepieObj implements Parcelable{
    String title;
    String thumbnail;
    String href;


    protected recepieObj(Parcel in) {
        title = in.readString();
        thumbnail = in.readString();
        href = in.readString();
    }

    public static final Creator<recepieObj> CREATOR = new Creator<recepieObj>() {
        @Override
        public recepieObj createFromParcel(Parcel in) {
            return new recepieObj(in);
        }

        @Override
        public recepieObj[] newArray(int size) {
            return new recepieObj[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(href);
    }
}
