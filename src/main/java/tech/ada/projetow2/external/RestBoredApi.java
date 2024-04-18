package tech.ada.projetow2.external;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

import tech.ada.projetow2.domain.dto.ActivityDto;

@Service
@RequiredArgsConstructor
public class RestBoredApi {
    private final RestTemplate restTemplate;

    public ActivityDto activity() {
        return restTemplate
                .getForEntity("https://www.boredapi.com/api/activity", ActivityDto.class)
                .getBody();
    }
}
