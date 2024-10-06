package example.c02_serviceLocator.cc02_upgrade;

public class ServiceLocator {
    static MailService getMailService(String serviceName) {
        MailService mailService = (MailService) ServiceCache.getInstance(serviceName);

        if (mailService != null) {
            System.out.println("* retrieve service from cache");
            return mailService;
        }

        System.out.println("* retrieve service from lookup");
        mailService = (MailService) ServiceContext.objectLookup(serviceName);
        ServiceCache.loadInstance(mailService);
        return mailService;
    }
}
