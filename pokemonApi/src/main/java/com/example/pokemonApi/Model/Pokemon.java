package com.example.pokemonApi.Model;

import com.sun.jdi.IntegerType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del pokemon es requerido")
    private String nombre;

    @NotBlank(message = "El tipo es requerido")
    private String tipo;

    @NotNull(message = "El nivel del pokemon es requerido")
    @Min(value = 0,message = "el nimvel del pokemon no puede ser negativo")
    @Max(value = 100, message = "El nivel maximo es 100")
    private Integer nivel;

    @Min(value = 0, message = "El ataque no puede ser negativo")
    private Integer ataque;

    @Min(value = 0, message = "La defensa no puede ser negativa")
    private Integer defensa;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Length(min = 100, max = 400)
    private String descripcion;

    @URL(message = "La imagen debe de ser una URL")
    private String imagenUrl;

    @Email(message = "El formato del correo no es valido")
    private String correoEntrenador;

    @PastOrPresent(message = "La fecha de nacimiento no puede ser pasada ni futura")
    private LocalDate fechaDeCaptura;

    @Positive(message = "El peso debe de ser positivo")
    private Double peso;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "El formato del telefono no es valido")
    private String telefono;

    @AssertTrue(message = "El pokemon debe de estar sano")
    private boolean debilitado;

}
