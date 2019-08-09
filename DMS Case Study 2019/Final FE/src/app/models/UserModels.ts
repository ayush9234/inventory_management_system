export class UserDetails{

    userName: string;
    email: string;
    contactNo: string;
    address: string;
    status: string;
    area: string;
    
}

export class UserProfile{
    userName: string;
    password: string;
    email: string;
    contactno: string;
    personalAddress: string;
    status: string;
    area: string;
    
}


export class RegisterUser{
    public userName: string;
    public email: string;
    public password: string;
    public personalAddress: string;
    public contactno: string;
    public status: string;
    public roleType: number;
    public area: string;
    
}

export class PasswordUpdator{
    public userId : number;
    public oldPassword : string;
    public newPassword : string;
}