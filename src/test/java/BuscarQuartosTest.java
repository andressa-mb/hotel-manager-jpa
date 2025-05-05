/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import br.com.senac.hotel.web.Models.Quartos;
import br.com.senac.hotel.web.persistencia.QuartosDAO;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Hóspedes devem poder filtrar por datas, quantidade de pessoas e faixa de preço.
 *
 * @author aulas
 */
public class BuscarQuartosTest {

    private QuartosDAO quartosDao;

    public BuscarQuartosTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        quartosDao = new QuartosDAO();
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testBuscarQuartosDisponiveis_Sucesso() {
        List<Quartos> resultado = quartosDao.filtrarQuartos(
                2,
                1,
                300,
                LocalDate.of(2025, 10, 1),
                LocalDate.of(2025, 10, 5)
        );

        assertNotNull(resultado);
        assertTrue(resultado.size() > 0, "Esperava-se encontrar quartos disponíveis");
    }

    @Test
    public void testBuscarQuartos_SemDisponibilidade() {
        List<Quartos> resultado = quartosDao.filtrarQuartos(
                2,
                1,
                400,
                LocalDate.of(2025, 12, 25),
                LocalDate.of(2025, 12, 31)
        );

        // Simulando que todos os quartos estão reservados nesse período
        assertTrue(resultado == null || resultado.isEmpty(), "Nenhum quarto deve estar disponível");
    }
}
