package com.tn.wechat.repo;

public interface IImageRepository {
    //return image url
    public boolean addImage(String key, byte[] content, String... attributes);

    public boolean delImage(String key, String... attributes);

    public boolean isExist(String key, String... attributes);

    public byte[] getImageById(String id, String... attributes);
}
