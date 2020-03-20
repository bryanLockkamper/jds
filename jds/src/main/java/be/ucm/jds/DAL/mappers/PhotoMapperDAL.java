package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import org.modelmapper.ModelMapper;

public class PhotoMapperDAL {
    public static Photo photoDAL_To_Photo(PhotoDAL photoDAL) {
        return new ModelMapper().map(photoDAL, Photo.class);
    }

    public static PhotoDAL photo_To_PhotoDAL(Photo photo) {
        return new ModelMapper().map(photo, PhotoDAL.class);
    }
}
