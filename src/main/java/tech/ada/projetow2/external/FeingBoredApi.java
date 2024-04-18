package tech.ada.projetow2.external;

import org.springframework.web.bind.annotation.GetMapping;
import tech.ada.projetow2.domain.dto.ActivityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;


@Service
@FeignClient(name = "Activities", url = "https://www.boredapi.com/api/activity")
public interface FeingBoredApi {
    @GetMapping
    ActivityDto getActivity();
}
