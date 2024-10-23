import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '38bd4276-2019-476e-b014-5aa304695bde',
};

export const sampleWithPartialData: IAuthority = {
  name: '5beb54c4-d0b7-40de-85f4-233721fca0a0',
};

export const sampleWithFullData: IAuthority = {
  name: '785741a1-717d-494a-8d75-deb10e770d2f',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
