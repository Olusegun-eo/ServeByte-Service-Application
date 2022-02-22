package com.ServeByteService.service.cloud.cloudinary;

import java.io.IOException;
import java.util.Map;

public interface CloudService {

    Map<?, ?> uploadLogo(byte [] bytes, Map<?, ?>params) throws IOException;
}
