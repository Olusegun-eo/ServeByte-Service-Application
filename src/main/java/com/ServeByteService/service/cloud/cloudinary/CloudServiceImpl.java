package com.ServeByteService.service.cloud.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service("cloudinary-service")
public class CloudServiceImpl implements CloudService{

    @Autowired
    Cloudinary cloudinary;

    @Override
    public Map<?, ?> uploadLogo(byte[] bytes, Map<?, ?> params) throws IOException {
        return cloudinary.uploader().upload(bytes, params);
    }
}
