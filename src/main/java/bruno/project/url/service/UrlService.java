package bruno.project.url.service;

import bruno.project.url.model.Url;
import bruno.project.url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;


    public String shortenUrl(String originalUrl){
        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setExpirationDate(LocalDateTime.now().plusDays(30));
        return shortUrl;
    }

    public Optional<Url> getOriginalUrl(String shortUrl){
        Optional<Url> urlOptional = urlRepository.findByShortUrl(shortUrl);
        if(urlOptional.isPresent()){
            Url url = urlOptional.get();
            if(url.getExpirationDate().isAfter(LocalDateTime.now())){
                return Optional.of(url);
            }else {
                urlRepository.delete(url);
            }
        }
        return Optional.empty();
    }

    private String generateShortUrl(){
        String characteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        int length = 5 + random.nextInt(6);
        for(int i = 0; i < length; i++){
            shortUrl.append(characteres.charAt(random.nextInt(characteres.length())));
        }
        return shortUrl.toString();
    }


}
