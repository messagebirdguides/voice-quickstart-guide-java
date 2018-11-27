import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;
import com.messagebird.exceptions.GeneralException;
import com.messagebird.exceptions.UnauthorizedException;
import com.messagebird.objects.VoiceMessage;
import com.messagebird.objects.VoiceMessageResponse;
import com.messagebird.objects.VoiceType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class VoiceQuickstart {
    public static void main(String[] args) {
        // Create a MessageBirdService
        final MessageBirdService messageBirdService = new MessageBirdServiceImpl("YOUR-API-KEY");
        // Add the service to the client
        final MessageBirdClient messageBirdClient = new MessageBirdClient(messageBirdService);

        // convert String number into acceptable format
        BigInteger phoneNumber = new BigInteger("319876543211");
        final List<BigInteger> phones = new ArrayList<BigInteger>();
        phones.add(phoneNumber);

        try {
            // Send a voice message using the VoiceMessage object
            final VoiceMessage vm = new VoiceMessage("Hey you, a little bird told me you wanted a call!", phones);
            vm.setVoice(VoiceType.male);

            final VoiceMessageResponse response = messageBirdClient.sendVoiceMessage(vm);
            System.out.println(response.toString());
        } catch (UnauthorizedException | GeneralException ex) {
            System.out.println(ex.toString());
        }
    }
}