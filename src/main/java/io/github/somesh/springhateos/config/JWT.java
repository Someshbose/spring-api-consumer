package io.github.somesh.springhateos.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties
public class JWT {

    @JsonProperty("access_token")
    private String accesToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private long expiredIn;

    @JsonProperty("scope")
    private String scope;


}
