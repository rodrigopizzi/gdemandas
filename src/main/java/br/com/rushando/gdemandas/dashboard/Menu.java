package br.com.rushando.gdemandas.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Menu {

    private String titulo;
    private String icone;
    private String endpoint;
    
} 