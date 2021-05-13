package adapters;
import java.rmi.RemoteException;

import abstracts.GamerCheckService;
import entities.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter {



    public class MernisServiceAdapter implements GamerCheckService{

        @Override
        public boolean checkIfRealPerson(Player player) {
            KPSPublicSoapProxy client = new KPSPublicSoapProxy();
            boolean result=true;
            try {
                result = client.TCKimlikNoDogrula(gamer.getNationalityId(), gamer.getFirstName().toUpperCase(),
                        gamer.getLastName().toUpperCase(), gamer.getDateOfBirth().getYear());
            }catch (RemoteException e) {
                e.printStackTrace();	}

            if(result==true)
                System.out.println(gamer.getFirstName() + " geçerli bir kiþi.");
            else
                System.out.println(gamer.getFirstName() + " geçersiz bir kiþi.");
            return result;

        }

}
