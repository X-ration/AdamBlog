package com.adam.adamblog.mood;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLConnection;

/**
 * @author adam
 * 创建于 2018-03-01 19:29.
 */
@Controller
public class ImageController {

    private MoodRepository moodRepository;

    @Autowired
    public ImageController(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @RequestMapping(value = "/image/mood/{imageUrl}", method = RequestMethod.GET)
    public void getMoodImage(HttpServletResponse response, @PathVariable String imageUrl) throws IOException {

        //String imageUrl = moodRepository.findById(moodId).getImageUrl();
        Resource resource = new FileSystemResource("./images/"+imageUrl);
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(resource.getFilename()));
        IOUtils.copy(resource.getInputStream(), response.getOutputStream());
    }


}
