import br.ufpb.dcx.petShop.Pet;
import br.ufpb.dcx.petShop.SistemaPetShop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class SistemaPetShopTest {
    private SistemaPetShop sistemaPet;

    @BeforeEach
    public void setup() {
        sistemaPet = new SistemaPetShop();
        sistemaPet.adicionarPet(new Pet("Rex", "Cachorro", 5, "Marrom"));
        sistemaPet.adicionarPet(new Pet("Bolinha", "Hamster", 2, "Branco"));
        sistemaPet.adicionarPet(new Pet("Frajola", "Gato", 3, "Preto"));
    }

    @Test
    public void adicionarPetTeste() {
        Pet pet = new Pet("Garfield", "Gato", 4, "Laranja");
        sistemaPet.adicionarPet(pet);
        List<Pet> pets = sistemaPet.listarPets();
        Assertions.assertEquals(4, pets.size());
        Assertions.assertTrue(pets.contains(pet));
    }

    @Test
    public void removerPetTeste() {
        Pet pet = sistemaPet.buscarPet("Rex");
        sistemaPet.removerPet(pet);
        List<Pet> pets = sistemaPet.listarPets();
        Assertions.assertEquals(2, pets.size());
        Assertions.assertFalse(pets.contains(pet));
    }

    @Test
    public void buscarPetExistenteTeste() {
        Pet pet = sistemaPet.buscarPet("Bolinha");
        Assertions.assertNotNull(pet);
        Assertions.assertEquals("Bolinha", pet.getNome());
    }

    @Test
    public void buscarPetInexistenteTeste() {
        Pet pet = sistemaPet.buscarPet("Garfield");
        Assertions.assertNull(pet);
    }
}
