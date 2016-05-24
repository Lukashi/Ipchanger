package kamac.lukasz.ipchanger;

public class Config {
    private String ip;
    private String mask;
    private String gateway;

    public Config() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(final String mask) {
        this.mask = mask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(final String gateway) {
        this.gateway = gateway;
    }
}