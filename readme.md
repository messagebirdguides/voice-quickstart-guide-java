# Make your first Voice Call with MessageBird

### ⏱ 10 min build time

It's time to make your first voice call using the MessageBird Voice API! Before we get started, have you set up your Java development environment and project directory with the MessageBird SDK?

* **No** - make sure you [read this MessageBird Developer Tutorial](https://developers.messagebird.com/tutorials/setup-local-dev-environment) before getting started.
* **Yes!** - Great! Now you can make your first API request and send an SMS message with MessageBird using Java.

## Getting started

First, let's create a new file in the directory of your `src/main/java` folder and call it `VoiceQuickstart.java`.

Start by importing the MessageBird Java library and creating an instance of the MessageBird client:

``` java
// Create a MessageBirdService
final MessageBirdService messageBirdService = new MessageBirdServiceImpl("YOUR-API-KEY");
// Add the service to the client
final MessageBirdClient messageBirdClient = new MessageBirdClient(messageBirdService);
```

Note that you can create either a **test** or **live** API key:

* **test** API keys simulate responses from the MessageBird server, allowing you to test your code flow and error handling before sending real messages. (You still must have an internet connection to use MessageBird REST API features.)
* **live** API keys allow you to send actual messages to your recipients. We recommend that you do not publish this key anywhere.
In order to start using the SDK, replace `YOUR-API-KEY` with your API key.

**Pro-tip**: Here, we're hardcoding your API key in your program to keep the tutorials straightforward. But for production applications, we recommended storing the key in a configuration file or environment variable instead and passing the variable to your application. You'll see this in practice later in our MessageBird Developer Tutorials for common use cases.

## Making a voice call

Now we can attempt create a voice call with a message as follows:

``` java
// Send a voice message using the VoiceMessage object
final VoiceMessage vm = new VoiceMessage("Hey you, a little bird told me you wanted a call!", phones);
vm.setVoice(VoiceType.male);

final VoiceMessageResponse response = messageBirdClient.sendVoiceMessage(vm);
```

Here, we're calling `sendVoiceMessage` with a single argument of type `VoiceMessage`. The voice message is configured with these parameters:

* The first parameter is the message that the recipient will hear on the call.
* The second parameter is the recipient's phone number, including the country code.

`VoiceMessage` can also be configured with optional attributes that you can specify for this phone call. Here, we're setting one of the optional attributes, the gender of the voice in the call, to "male". You can find more information about other optional attributes in the [Voice Calling API Reference](https://developers.messagebird.com/docs/voice-calling#calls).

If the call succeeds, the application will print details about the call to the console.

We've used an example phone number for the recipient's phone number. For your application to work, you should replace this number with a working number.

If the attempt to create a voice call fails, we print the errors to the console with the following clause:

``` java
try {
    // Send a voice message using the VoiceMessage object
    final VoiceMessage vm = new VoiceMessage("Hey you, a little bird told me you wanted a call!", phones);
    vm.setVoice(VoiceType.male);

    final VoiceMessageResponse response = messageBirdClient.sendVoiceMessage(vm);
    System.out.println(response.toString());
} catch (UnauthorizedException | GeneralException ex) {
    System.out.println(ex.toString());
}
```

## Finishing your program

Once you've done all that, you have a fully functioning Java program that makes a call to your set destination phone number when run.

To test your application, run it in your IDE.

If everything worked, you should see the API response logged in the terminal, signaling that you've successfully made a call.

If you used a live API key and had verified your number or added credits to your account, your phone will ring shortly and deliver the message when you pick up the phone. Congratulations, you just initiated your first voice call with MessageBird!

If you see an error from the script, try to read and understand the message and fix the problem.

## Next steps

Let's head over to the next MessageBird Developer Tutorial learn how to [set up and handle incoming voice calls](https://developers.messagebird.com/tutorials/handle-incoming-calls-and-sms).

Want to start building your solution but not quite sure how to get started? Please feel free to let us know at support@messagebird.com, we'd love to help!
